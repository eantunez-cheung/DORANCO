package fr.doranco.ecommerce.utils;

import java.text.SimpleDateFormat;
import java.time.ZoneId;

/**
 * Classe finale non instantiable.
 * Expose des m�thodes de conversion de date.
 * 
 * @author Thi Van Anh
 * @since 1.0
 *
 */
public final class Dates {

	private static final String formatDate = "dd/MM/yyyy";

	/**
	 * Constructuer priv�. n'autorise donc pas d'instancier cette classe.
	 */
	private Dates() {
	}

	/**
	 * Permet de convertir une date de type {@link java.util.Date} vers une date de type {@link java.sql.Date}.
	 * 
	 * @param date : la date � convertir (de type {@link java.util.Date}).
	 * @return la date r�sultat de la conversion (de type {@link java.sql.Date}).
	 * @throws NullPointerException
	 * @see
	 * <ul>
	 * <li>{@link convertDateSqlToDateUtil}</li>
	 * <li>{@link convertStringToDateUtil}</li>
	 * <li>{@link convertDateUtilToString}</li>
	 * </ul>
	 */
	public static final java.sql.Date convertDateUtilToDateSql(java.util.Date date) throws NullPointerException {
		if (date == null) {
			throw new NullPointerException("la date � convertir ne doit pas �tre nulle !");
		}
		return new java.sql.Date(date.getTime());
	}

	/**
	 * 
	 * @param date
	 * @return
	 * @throws NullPointerException
	 */
	public static final java.util.Date convertDateSqlToDateUtil(java.sql.Date date) throws NullPointerException {
		if (date == null) {
			throw new NullPointerException("la date � convertir ne doit pas �tre nulle !");
		}
		return new java.util.Date(date.getTime());
	}
	
	public static final java.util.Date convertStringToDateUtil(String dateStr) throws Exception {
		if (dateStr == null || dateStr.trim().isEmpty()) {
			throw new NullPointerException("la date � convertir ne doit pas �tre nulle ou vide !");
		}
		SimpleDateFormat formatter = new SimpleDateFormat(formatDate);
		return formatter.parse(dateStr);
	}

	public static final String convertDateUtilToString(java.util.Date date) throws Exception {
		if (date == null) {
			throw new NullPointerException("la date � convertir ne doit pas �tre nulle !");
		}
		SimpleDateFormat formatter = new SimpleDateFormat(formatDate);
		return formatter.format(date);
	}
	
	public static java.util.Date convertDateTimeToDateUtil(java.time.LocalDate date) throws Exception {
		if (date == null) {
			throw new NullPointerException("la date � convertir ne doit pas �tre nulle !");
		}
		return java.util.Date.from(date.atStartOfDay()
									.atZone(ZoneId.systemDefault())
									.toInstant());
	}

}
