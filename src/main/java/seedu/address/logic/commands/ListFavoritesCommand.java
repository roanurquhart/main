package seedu.address.logic.commands;


import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

public class ListFavoritesCommand extends Command{

    public static final String COMMAND_WORD = "listFav";
    public static final String MESSAGE_SUCCESS = "Listed all favorites";

    @Override
    public CommandResult execute(Model model, CommandHistory history) {
        requireNonNull(model);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
