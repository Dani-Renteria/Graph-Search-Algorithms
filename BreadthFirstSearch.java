import java.util.*;

public class BreadthFirstSearch implements GraphSearchAlgorithm {

            public Path search(State start, State goal) {
                Path startPath = new Path(start);

                LinkedList<Path> FrontierL = new LinkedList<>();
                HashSet<State> visitedH = new HashSet<>();


                FrontierL.add(startPath);
                while (FrontierL.size() != 0) {
                    Path poppedPath = FrontierL.pop();
                    if (!visitedH.contains(poppedPath.getLastState())) {
                        if (poppedPath.getLastState().equals(goal)) {
                            return poppedPath;
                        }
                        else {
                            List<Action> actions = poppedPath.getLastState().getActions();
                            for (int i = 0; i <= actions.size()-1; i++) {
                                FrontierL.add(new Path(poppedPath, actions.get(i)));
                            }
                        }
                        visitedH.add(poppedPath.getLastState());
                    }
                }
                return null;
            }


}
