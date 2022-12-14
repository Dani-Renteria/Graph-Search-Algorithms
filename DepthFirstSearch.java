import java.util.*;

public class DepthFirstSearch implements GraphSearchAlgorithm {

    public Path search(State start, State goal) {
        Path startPath = new Path(start);

        LinkedList<Path> FrontierS = new LinkedList<>();
        HashSet<State> visitedH = new HashSet<>();

        FrontierS.add(startPath);
        while (FrontierS.size()!= 0) {
            Path poppedPath = FrontierS.pollLast();
            if (!visitedH.contains(poppedPath.getLastState())){
                if(poppedPath.getLastState().equals(goal)){
                    return poppedPath;
                }
                else {
                    List<Action> actions = poppedPath.getLastState().getActions();
                    for (int i = 0; i < actions.size(); i++) {
                        FrontierS.add(new Path(poppedPath, actions.get(i)));
                    }
                }
                visitedH.add(poppedPath.getLastState());
            }
        }
        return null;

    }
}
