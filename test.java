import java.util.*;

public class test {

    public static int leastBricks(List<List<Integer>> wall) {
        int width = 0;
        for (int i = 0; i < wall.get(0).size(); i++) {
            width += wall.get(0).get(i);
        }
        if (width == 1) {
            return wall.size();
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < width; i++) {
            int count = 0;
            for (List<Integer> l : wall) {
                System.out.println("l: " + l);

                for (int j = 0; j < l.size(); j++) {
                    if (l.get(j) != 0) {
                        l.set(j, l.get(j) - 1);
                        if (l.get(j) != 0) {
                            count++;
                        } else {
                            l.set(j, 0);
                        }
                        break;
                    }

                }

            }
            if (count == 0) {
                break;
            }
            System.out.println("RESULTS: " + res + " " + count);
            res = Math.min(res, count);
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 2, 2, 1));
        list.add(Arrays.asList(3, 1, 2));
        list.add(Arrays.asList(1, 3, 2));
        list.add(Arrays.asList(2, 4));
        list.add(Arrays.asList(3, 1, 2));
        list.add(Arrays.asList(1, 3, 1, 1));
        System.out.println(leastBricks(list));
    }

}
