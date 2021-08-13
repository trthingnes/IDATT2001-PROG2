# Project comments

### Package structure

The final package structure was chosen because it felt natural to organize the project in packages that respected
inheritance. Therefore, there is a package `hospital.person` that includes the abstract class `Person` as well as the
class `Patient` and the interface `Diagnosable`.

Inside the `hospital.person` package there is a subpackage `hospital.person.employee` which includes the `Employee` and
`Nurse` classes. Inside the `employee` subpackage there is another subpackage `employee.doctor` that includes the
abstract
`Doctor` class as well as the two classes extending `Doctor`: `GeneralPractitioner` and `Surgeon`.

### Method and variable names

In the final project I ended up changing the name of the `.remove(Person p)` method in `Department` to
`.removePerson(Person p)`. This is to be as clear as possible about what we are removing.

To make the code as versatile as possible I also chose to change the `socialSecurityNumber` property
to `personalIdNumber`
since what you call the personal ID number varies between countries.