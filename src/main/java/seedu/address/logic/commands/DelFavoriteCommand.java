package seedu.address.logic.commands;

import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.NameMatchesPredicate;

import static java.util.Objects.requireNonNull;

public class DelFavoriteCommand extends Command {

    public static final String COMMAND_WORD = "delFav";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes a person from the favorites list\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD
            + " Alex Yeoh";

    public static final String MESSAGE_SUCCESS = "Person deleted";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person doesn't exist in the favorite list";
    public static final String MESSAGE_NOT_SPECIFIC = "Please be more specific";


    private final NameMatchesPredicate predicate;
    private final NameContainsKeywordsPredicate containsPredicate;

    public DelFavoriteCommand(NameMatchesPredicate predicate, NameContainsKeywordsPredicate containsPredicate) {
        this.predicate = predicate;
        this.containsPredicate = containsPredicate;
    }



    @Override
    public CommandResult execute(Model model, CommandHistory history) {
        requireNonNull(model);
        model.updateFilteredPersonList(predicate);

        if (model.getFilteredPersonList().size() != 1) {
            model.updateFilteredPersonList(containsPredicate);
            return new CommandResult(String.format(MESSAGE_NOT_SPECIFIC));
        } else {
            model.removeFavorite(model.getFilteredPersonList().get(0));
            model.commitAddressBook();
            return new CommandResult(String.format(MESSAGE_SUCCESS));
        }
    }


    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DelFavoriteCommand // instanceof handles nulls
                && predicate.equals(((DelFavoriteCommand) other).predicate)); // state check
    }
}
