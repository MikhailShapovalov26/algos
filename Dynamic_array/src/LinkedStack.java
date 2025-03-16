public class LinkedStack {
    private Node tail; // ссылка на последний добавленный узел (обёртку)
    private int size; // размер стека, т.е. количество элементов в нём

    public void push(int value) {
        Node node = new Node(value); // создаём новый узел
        if (tail != null) { // если в стеке уже есть элементы
            node.setPrev(tail); // связываем новый узел с последним
        }
        tail = node; // назначаем новый узел последним узлом
        size++; // увеличиваем счётчик элементов
    }

    public int pop() {
        // ваш код
        // возьмите value из последнего узла
        // назначьте предыдущий к последнему узлу последним узлом
        if (isEmpty()) {
            System.out.println("The stack is empty");
            return 0;
        }
        int deleteElement = this.tail.getValue();

        this.tail=tail.getPrev();
        size--;

        return deleteElement;
    }


    public int getSize() {
        // ваш код
        // верните размер стека
        return this.size;
    }

    public boolean isEmpty() {
        // ваш код
        // верните ответ на вопрос, не пустой ли стек
        return tail == null;
    }

    public String toString() {
        // если есть элементы, пройдитесь по связному списку,
        // выводя элементы.
        // вывод должен быть в точности как в комментариях к main
        // при этом этот метод не должен менять стек!
        StringBuilder printResult = new StringBuilder();
        Node current = tail;
        int count = size;
        if(count == 0){
            return "EMPTY";

        }
        while (current != null) {
            if (count > 1) {
                printResult.append(current.getValue() + " -> ");
            } else {
                printResult.append(current.getValue());
            }
            count--;

            current = current.getPrev();

        }
        return printResult.toString();

    }
}
