package seedu.tp.group;

import org.junit.jupiter.api.Test;
import seedu.tp.exceptions.InvalidFlashcardIndexException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.tp.utils.ExampleInputConstants.DESCRIPTION;
import static seedu.tp.utils.ExampleInputConstants.FULL_FLASHCARD_LIST;
import static seedu.tp.utils.ExampleInputConstants.GROUP_NAME;
import static seedu.tp.utils.ExampleInputConstants.INDEXES_1;
import static seedu.tp.utils.ExampleInputConstants.SIMULATED_GROUP_COMMAND_INPUT_1;
import static seedu.tp.utils.ExampleInputConstants.SIMULATED_GROUP_COMMAND_INPUT_2;
import static seedu.tp.utils.InputTestUtil.convertStringIndexesToIntArray;
import static seedu.tp.utils.InputTestUtil.getGroupFactoryWithInput;

public class GroupFactoryTest {
    @Test
    public void group_correctly_formed() throws InvalidFlashcardIndexException {
        FlashcardGroup expectedGroup = new FlashcardGroup(GROUP_NAME, DESCRIPTION, FULL_FLASHCARD_LIST,
            convertStringIndexesToIntArray(INDEXES_1));
        GroupFactory groupFactory = getGroupFactoryWithInput(SIMULATED_GROUP_COMMAND_INPUT_1, FULL_FLASHCARD_LIST);
        FlashcardGroup actualGroup = groupFactory.form();

        assertEquals(expectedGroup, actualGroup);
    }

    @Test
    public void groupFactory_invalidFlashcardIndex_throwsException() {
        GroupFactory groupFactory = getGroupFactoryWithInput(SIMULATED_GROUP_COMMAND_INPUT_2, FULL_FLASHCARD_LIST);
        assertThrows(
            InvalidFlashcardIndexException.class, groupFactory::form
        );
    }
}