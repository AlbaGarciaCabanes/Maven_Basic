package pruebas;

import java.util.ArrayList;
import java.util.List;

public class Programame {

	public List<String> problemaA(List<String> entrada) {
		ArrayList salida = new ArrayList<>();
		if (entrada.size() < 1) {
			salida.add("Error");
			return salida;
		}
		int numOperaciones = Integer.parseInt(entrada.get(0));
		for (int i = 1; i <= numOperaciones; i++) {
			int z = entrada.get(i).indexOf(" ", 0);
			int x = 0;
			String numero[];
			numero = new String[3];
			int indi = 0;
			while (z != -1) {
				numero[indi] = (entrada.get(i).substring(x, z));
				x = z + 1;
				z = x;
				z = entrada.get(i).indexOf(" ", z);
				indi++;
			}
			numero[indi] = entrada.get(i).substring(x, entrada.get(i).length());
			if (numero[1].equals("+"))
				salida.add("" + (Integer.parseInt(numero[0]) + Integer.parseInt(numero[2])));
			if (numero[1].equals("-"))
				salida.add("" + (Integer.parseInt(numero[0]) - Integer.parseInt(numero[2])));
			if (numero[1].equals("*"))
				salida.add("" + (Integer.parseInt(numero[0]) * Integer.parseInt(numero[2])));
			if (numero[1].equals("/")) {
				if (numero[0].equals("0") || numero[2].equals("0"))
					salida.add("ERROR");
				else
					salida.add("" + (Integer.parseInt(numero[0]) / Integer.parseInt(numero[2])));
			}
		}
		return salida;
	}

	public List<String> problemaB(List<String> entrada) {
		ArrayList salida = new ArrayList<>();
		if (entrada.size() < 1) {
			salida.add("ERROR");
			return salida;
		}
		int numOperaciones = Integer.parseInt(entrada.get(0));
		for (int i = 1; i <= numOperaciones; i++) {
			List<String> cadena = new ArrayList<>();
			int x = 0;
			int y = 1;
			for (int j = 0; j < entrada.get(i).length(); j++) {
				if (!testea(entrada.get(i).substring(x, y)))
					cadena.add((entrada.get(i).substring(x, y).toLowerCase()));
				x += 1;
				y += 1;

			}

			String letra = cadena.get(0);
			Boolean ordenada = true;
			if (cadena.size() > 1)
				for (int j = 1; j < cadena.size(); j++) {
					if (letra.compareTo(cadena.get(j)) > 0) {
						ordenada = false;
					}
					letra = cadena.get(j);

				}
			if (ordenada)
				salida.add("ERROR");
			else
				salida.add("OK");
		}
		return salida;
	}
	
	private boolean testea(String letra) {
		String vocales[] = { "a", "A", "e", "E", "i", "I", "o", "O", "u", "U"};
		for (int i = 0; i < vocales.length; i++) {
			if (letra.equals(vocales[i]))
				return true;
		}
		return false;
	}
	

	public List<String> problemaC(List<String> entrada) {
		ArrayList salida = new ArrayList<>();
		if (entrada.size() < 1) {
			salida.add("ERROR");
			return salida;
		}

		int numOperaciones = Integer.parseInt(entrada.get(0));
		for (int i = 1; i <= numOperaciones; i++) {
			List<String> primos = new ArrayList<>();
			int numMax = Integer.parseInt(entrada.get(i));
			for (int j = numMax; j > 9; j--) {
				Boolean primo = true;
				for (int x = 2; x < j; x++)
					if (j % x == 0) {
						primo = false;
						break;
					}
				if (primo)
					primos.add("" + j);
			}
			int contador = 0;
			for (int j = 0; j < primos.size(); j++) {
				if (primos.get(j).substring(0, 1).equals("1"))
					contador++;
			}
			salida.add("" + contador);
		}
		return salida;
	}

	public List<String> problemaD(List<String> entrada) {
		ArrayList salida = new ArrayList<>();
		if (entrada.size() < 1) {
			salida.add("Error");
			return salida;
		}
		
		return salida;
	}

	public List<String> problemaE(List<String> entrada) {
		ArrayList salida = null;
		salida = new ArrayList<>();
		if (entrada.size() < 1) {
			salida.add("ERROR");
			return salida;
		}

		int numOperaciones = Integer.parseInt(entrada.get(0));
		for (int i = 1, i2 = 1; i <= numOperaciones; i++) {
			salida.add("Caso " + i + ":");
			int oxigeno = Integer.parseInt(entrada.get(i2));
			int num = Integer.parseInt(entrada.get(i2 + 1));
			int valores[][] = new int[num][2];
			for (int j = 0; j < num; j++) {
				valores[j][0] = Integer
						.parseInt(entrada.get(j + i2 + 2).substring(0, entrada.get(j + i2 + 2).indexOf(" ")));
				valores[j][1] = Integer.parseInt(entrada.get(j + i2 + 2)
						.substring(entrada.get(j + i2 + 2).indexOf(" ") + 1, entrada.get(j + i2 + 2).length()));
			}

			for (int x = 0; x < (valores.length - 1); x++) {
				for (int j = x + 1; j < valores.length; j++) {
					if (valores[x][1] > valores[j][1]) {
						int variableauxiliar1 = valores[x][1];
						int variableauxiliar0 = valores[x][0];
						valores[x][1] = valores[j][1];
						valores[x][0] = valores[j][0];
						valores[j][1] = variableauxiliar1;
						valores[j][0] = variableauxiliar0;
					}
				}
			}
			for (int x = valores.length - 1; x > 0; x--) {
				for (int j = x - 1; j > -1; j--) {
					if (valores[x][0] >= oxigeno && valores[x][0] > valores[j][0]) {
						int aux1 = valores[x][1];
						int aux2 = valores[x][0];
						valores[x][1] = valores[j][1];
						valores[x][0] = valores[j][0];
						valores[j][1] = aux1;
						valores[j][0] = aux2;
					}
				}
			}

			for (int j = 0; j < valores.length; j++)
				salida.add(valores[j][0] + " " + valores[j][1]);
			i2 += num + 2;

		}
		return salida;
	}

}
