package adventofcode.day24;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<Component> components = new ArrayList<>();

    public Bridge(Component first) {
        components.add(first);
    }

    public Bridge(Bridge other) {
        this.components = new ArrayList<>(other.getComponents());
    }

    int getStrength() {
        return components.stream().map(Component::getSum).reduce((c1, c2)->c1+c2).get();
    }

    Bridge add(List<Component> components) {
        this.components.addAll(components);
        return this;
    }

    @Override
    public String toString() {
        return "Bridge{" +
                "components=" + components +
                '}';
    }

    public List<Component> getComponents() {
        return components;
    }

    public List<Component> findNext(List<Component> input) {
        List<Component> next = new ArrayList<>();
        List<Component> remaining = new ArrayList<>(input);
        remaining.removeAll(components);
        remaining.forEach(component -> {
            Component last = components.get(components.size() - 1);
            if (last.match(component)) {
                Component copy = component.copy();
                copy.setUsed(last.getUnused());
                next.add(copy);
            }
        });
//        System.out.println("Found next components for " + components.get(components.size() - 1)+": " + next);
        return next;
    }

    public Bridge add(Component component) {
        this.components.add(component);
        return this;
    }

    public Integer getLength() {
        return components.size();
    }
}
