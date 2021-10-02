package balance_parenthesis;


interface Grouper{
    boolean matchedElements(Grouper grouperElement);
    Character getItem();
    boolean isOpener();
    boolean isCloser();
}


record Bracket(Character charItem) implements Grouper{

    @Override
    public boolean matchedElements(Grouper grouperElement) {
        return this.isOpener() && grouperElement.isCloser() && grouperElement.getClass() == Bracket.class;
    }

    @Override
    public Character getItem(){
        return this.charItem;
    }

    @Override
    public boolean isOpener() {
        return this.charItem == '[';
    }

    @Override
    public boolean isCloser() {
        return this.charItem == ']';
    }
}

record Key(Character charItem) implements Grouper{

    @Override
    public boolean matchedElements(Grouper grouperElement) {
        return this.isOpener() && grouperElement.isCloser() && grouperElement.getClass() == Key.class;
    }

    @Override
    public Character getItem(){
        return this.charItem;
    }

    @Override
    public boolean isOpener() {
        return this.charItem == '{';
    }

    @Override
    public boolean isCloser() {
        return this.charItem == '}';
    }
}


record Parenthesis(Character charItem) implements Grouper{

    @Override
    public boolean matchedElements(Grouper grouperElement) {
        return this.isOpener() && grouperElement.isCloser() && grouperElement.getClass() == Parenthesis.class;
    }

    @Override
    public Character getItem(){
        return this.charItem;
    }

    @Override
    public boolean isOpener() {
        return this.charItem == '(';
    }

    @Override
    public boolean isCloser() {
        return this.charItem == ')';
    }
}