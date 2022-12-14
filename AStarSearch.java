import java.util.*;

public class AStarSearch implements GraphSearchAlgorithm {

    public Path search(State start, State goal) {
        Path startPath = new Path(start);
        HashMap<State, State> visitedH = new HashMap<>();
        PathPriorityQueue Frontier = new PathPriorityQueue();

        if (start.getActions().size() == 0){
            return null;
        }
        Frontier.add(startPath,start.heuristicTo(goal)+ startPath.getCost() );
        while (!Frontier.isEmpty()) {
            Path poppedPath = Frontier.poll();

            if(poppedPath.getLastState().equals(goal)){
                return poppedPath;
            }
            else if (!visitedH.containsKey(poppedPath.getLastState())){
                List<Action> actions = poppedPath.getLastState().getActions();
                for (int i = 0; i <= actions.size()-1; i++) {
                    Path neighbor = new Path (poppedPath, actions.get(i));
                    Frontier.add(neighbor, neighbor.getLastState().heuristicTo(goal)+ neighbor.getCost());
                }
                visitedH.put(poppedPath.getLastState(), poppedPath.getLastState());
            }
        }
        return null;
    }

}
