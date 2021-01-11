public class AutoArray<T> {
    Item<T> head;

    AutoArray() {
        head = null;
    }

    void add(T value) {
        if (head == null) {
            head = new Item<>(value);
        } else {
            Item<T> buf = head;
            while (buf.getNextValue() != null) {
                buf = buf.getNextValue();
            }
            buf.setNextValue(value);
        }
    }

    int getSize() {
        int counter = 0;
        Item<T> buf = head;
        while (buf != null) {
            counter++;
            buf = buf.getNextValue();
        }
        return counter;
    }

    T get(int pos) {
        int counter = 0;
        Item<T> buf = head;
        while (buf != null) {
            if (counter == pos) {
                return buf.getValue();
            } else {
                buf = buf.getNextValue();
                counter++;
            }
        }
        return null;
    }

    static class Item<T> {
        private T value;
        private Item<T> nextValue;

        Item(T value) {
            this.value = value;
            nextValue = null;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Item<T> getNextValue() {
            return nextValue;
        }

        public void setNextValue(T nextValue) {
            this.nextValue = new Item<>(nextValue);
        }
    }
}
