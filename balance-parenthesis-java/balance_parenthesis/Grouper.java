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
        boolean result = false;
        if (this.isOpener() && grouperElement.isCloser()){
            result = true;
        }
        return result;
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
        boolean result = false;
        if (this.isOpener() && grouperElement.isCloser()){
            result = true;
        }
        return result;
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
        boolean result = false;
        if (this.isOpener() && grouperElement.isCloser()){
            result = true;
        }
        return result;
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