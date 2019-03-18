package seedu.address.logic.commands;


import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;

public class ListFavoritesCommand extends Command{

    public static final String COMMAND_WORD = "listFav";
    public static final String MESSAGE_SUCCESS = "Listed all favorites";

    @Override
    public CommandResult execute(Model model, CommandHistory history) {
        requireNonNull(model);
        System.out.println(model.getFavoritesList());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
