package seedu.addressbook.ui;

import java.util.List;

public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    public static final String COMMENT_LINE_FORMAT_REGEX = "#.*";
    
    /**
     * Add line prefix to the message
     */
    public static String addLinePrefix(String message) {
    	return LINE_PREFIX + message;
    }
    
    /**
     * Wrap user input
     */
    public static String wrapInput(String input) {
    	return "[Command entered:" + input + "]";
    }
    
    /**
     * Format a line
     */
    public static String formatLine(String line) {
    	return LINE_PREFIX + line.replace("\n", LS + LINE_PREFIX);
    }
    
    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    public static String formatIndexedListItem(int visibleIndex, String listItem) {
    	return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(formatIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }
   
}
