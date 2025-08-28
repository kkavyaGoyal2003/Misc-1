//time complexity- O(n)
//space complexity- O(n)
import java.util.*;
public class WeightSumOfNestedList {
    public interface NestedInteger {
        boolean isInteger();
        Integer getInteger();
        void setInteger(int value);
        void add(NestedInteger ni);
        List<NestedInteger> getList();
    }
    public static class NestedIntegerImpl implements NestedInteger {
        private Integer value;
        private List<NestedInteger> list;
        public NestedIntegerImpl() {
            list = new ArrayList<>();
        }
        public NestedIntegerImpl(int value) {
            this.value = value;
        }
        public boolean isInteger() {
            return value != null;
        }
        public Integer getInteger() {
            return value;
        }
         public void setInteger(int value) {
            this.value = value;
            this.list = null;
        }
        public void add(NestedInteger ni) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(ni);
        }
        public List<NestedInteger> getList() {
            return list;
        }
    }

    static int depthSum(List<NestedInteger> nestedList) {
        int result = 0;
        Queue<NestedInteger> q = new LinkedList<>();
        int depth = 1;
        q.addAll(nestedList);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                NestedInteger curr = q.poll();
                if (curr.isInteger()) {
                    result += curr.getInteger() * depth;
                } else {
                    q.addAll(curr.getList());
                }
            }
            depth++;
        }
        return result;
    }
    public static void main(String[] args) {
        List<NestedInteger> input = new ArrayList<>();
        NestedIntegerImpl outerList = new NestedIntegerImpl();
        NestedIntegerImpl li1 = new NestedIntegerImpl();
        NestedIntegerImpl li2 = new NestedIntegerImpl();
        NestedIntegerImpl li3 = new NestedIntegerImpl();
        NestedIntegerImpl li4 = new NestedIntegerImpl();

        li4.add(new NestedIntegerImpl(2));
        li3.add(new NestedIntegerImpl(1));
        li3.add(li4);

        li2.add(new NestedIntegerImpl(4));
        li2.add(li3);

        li1.add(new NestedIntegerImpl(1));
        li1.add(new NestedIntegerImpl(2));

        outerList.add(li1);
        outerList.add(new NestedIntegerImpl(3));
        outerList.add(li2);
        input.addAll(outerList.getList());
        int result = depthSum(input);
        System.out.println("Weighted sum is: " + result);
    }
}
