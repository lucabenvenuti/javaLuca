import java.util.*;

/**
 * PhoneBookNode.java
 *
 * A {@link PhoneBookNode} is used to creates a tree of a phonebook, whereas every node can store a
 * telephone numbers, all node store 1 character of the name and leafs always store a telephone
 * number.
 *
 * Software Development I, 2014WS Institute for Pervasive Computing, JKU Linz
 *
 * @author Michael Haslgrübler
 * @author Andreas Riener
 * @version 2014-12-23
 */

public class PhoneBookNode implements Comparable<PhoneBookNode> {
    private char code;
    private String telephoneNumber;
    private TreeSet<PhoneBookNode> children;

    public PhoneBookNode(char code, String telephoneNumber) {
        super();
        this.code = code;
        this.telephoneNumber = telephoneNumber;
        this.children = new TreeSet<PhoneBookNode>();
    }

    public PhoneBookNode(char code) {
        this(code, null);
    }

    public SortedSet<PhoneBookNode> getChildren() {
        return children;
    }

    public char getCode() {
        return code;
    }

    public void setCode(char code) {
        this.code = code;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public boolean insert(String name, String number) {
        if (name.length() == 0) {
            if (getTelephoneNumber() == null) {
                setTelephoneNumber(number);
                return true;
            } else {
                return false;
            }
        }

        String uName = name.toUpperCase();
        char childCode = uName.charAt(0);
        PhoneBookNode nextNode = null;
        for (PhoneBookNode child : getChildren()) {
            if (child.getCode() == childCode) {
                nextNode = child;
                break;
            }
        }
        if (nextNode == null) {
            nextNode = new PhoneBookNode(childCode);
            getChildren().add(nextNode);
        }

        return nextNode.insert(uName.substring(1), number);
    }

    public PhoneBookNode search(String name) {
        if (name.length() == 0) {
            return this;
        }

        char childCode = name.toUpperCase().charAt(0);
        for (PhoneBookNode child : children) {
            if (child.getCode() == childCode) {
                return child.search(name.substring(1));
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return printPhoneBook(""); // String representation of the entire tree
    }

    /**
     * This method creates a String representation of the tree starting with the current node. Each
     * line will consist of: prefix, code and the telephone number. For every child of this node,
     * this method has to be called recursively adding the code of this node to the prefix. In
     * total, the method will return the prefix, code and telephone number of this node followed by
     * the same of all of its descendants.
     *
     * @param prefix a prefix text which should be prepended to every line
     * @return a string representation of a {@link PhoneBookNode} tree starting with this node
     */
    public String printPhoneBook(String prefix) {
        StringBuilder retVal = new StringBuilder();

        if (getTelephoneNumber() != null) {
            retVal.append(prefix).append(getCode()).append("\t").append(getTelephoneNumber()).append("\n");
        }

        String newPrefix;
        if (getCode() == '\0') {
            newPrefix = "";
        } else {
            newPrefix = prefix + String.valueOf(getCode());
        }
        for (PhoneBookNode child : getChildren()) {
            retVal.append(child.printPhoneBook(newPrefix));
        }
        return retVal.toString();
    }

    @Override
    public int compareTo(PhoneBookNode o) {
        return Character.compare(this.code, o.getCode());
    }
}