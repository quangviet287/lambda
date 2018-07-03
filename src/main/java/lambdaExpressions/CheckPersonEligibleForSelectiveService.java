package lambdaExpressions;

public class CheckPersonEligibleForSelectiveService implements CheckPerson{
    @Override
    public boolean test(Person person) {
        return person.gender == Person.Sex.MALE && person.getAge()>=19 && person.getAge() <=24;
    }
}
