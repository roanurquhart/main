package seedu.address.model.person;
import seedu.address.model.Model;

import java.util.function.Predicate;

public class PersonIsFavoritePredicate implements Predicate<Person> {

    private Model model;

    public PersonIsFavoritePredicate(Model model){ this.model = model; }

    @Override
    public boolean test(Person person) {
        return model.getFavoritesList().contains(person);
    }
}
