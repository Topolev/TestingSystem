package by.topolev.testing.bisness.convertors;

public interface Convertor<BISNESS_DATA,FORM_DATA> {
	 BISNESS_DATA  createBisnessClassFromFormData(FORM_DATA form);
}
