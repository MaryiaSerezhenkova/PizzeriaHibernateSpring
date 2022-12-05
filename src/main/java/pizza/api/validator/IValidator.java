package pizza.api.validator;


public interface IValidator<TYPE> {
	void validate(TYPE t);

}
