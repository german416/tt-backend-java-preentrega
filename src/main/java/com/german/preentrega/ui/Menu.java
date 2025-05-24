package com.german.preentrega.ui;

import com.german.preentrega.exceptions.DuplicateIndexException;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    //#region ATRIBUTOS
    private final ArrayList<Option> options;
    private final String title;
    private final String body;
    private String footer;
    private Character selectedOption;

    // @todo: poner escaner estatico
    //#endregion

    //#region CONSTRUCTORES
    public Menu() {
        options = new ArrayList<Option>();
        selectedOption = null;
        title = "";
        body = "";
        footer = "";
    }

    public Menu(String title, String body, String footer) {
        options = new ArrayList<Option>();
        selectedOption = null;
        this.title = title;
        this.body = body;
        this.footer = footer;
    }

    public Menu(String title, String body) {
        options = new ArrayList<Option>();
        selectedOption = null;
        this.title = title;
        this.body = body;
        this.footer = "";
    }

    public Menu(String title) {
        options = new ArrayList<Option>();
        selectedOption = null;
        this.title = title;
        body = "";
        footer = "";
    }
    //#endregion

    //#region MÉTODOS PÚBLICOS
    /**
     * Agrega una nueva opción a la lista de opciones del menú.
     *
     * <p>Este método crea una nueva instancia de la clase {@link Option} con el mensaje
     * y el índice proporcionados, y la agrega a la lista de opciones. Si el índice
     * ya existe en la lista, se lanza una excepción {@link DuplicateIndexException}.</p>
     *
     * @param message El mensaje que describe la opción. No puede ser {@code null}.
     * @param index El índice único que identifica la opción. No puede ser {@code null}.
     * @throws DuplicateIndexException Si el índice ya existe en la lista de opciones.
     */
    public void addOption(String message, char index) throws Exception {
        if(indexExist(index)) {
            throw new DuplicateIndexException();
        }
        Option newOption = new Option(message, index);
        options.add(newOption);
    }

    /**
     * Imprime en la consola el contenido del menú: título, cuerpo, opciones y footer.
     */
    public void print() {
        System.out.println(title);
        System.out.println(body);
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getLabel());
        }
        System.out.println(footer);
    }

    public void run() {
        print();
        chooseValidOption();
    }
    //#endregion

    //#region MÉTODOS PRIVADOS
    /**
     * Verifica si un índice específico existe dentro de las opciones del menú.
     * <p>
     * Este método consulta la lista de índices de las opciones del menú y verifica si
     * el índice proporcionado está presente en la misma.
     * </p>
     *
     * @param index El carácter que representa el índice a verificar.
     * @return <code>true</code> si el índice existe en el menú, <code>false</code> en caso contrario.
     */
    private boolean indexExist(char index) {
        ArrayList<Character> indexList = getIndexList();
        return indexList.contains(index);
    }

    /**
     * Retorna una lista de caracteres que representan los identificadores asignados
     * a cada opción del menú.
     * <p>
     * Un identificador es un carácter alfanumérico asociado a una opción del menú,
     * que se utiliza para seleccionar la opción cuando esta es elegida.
     * </p>
     *
     * @return Un tipo de dato <code>ArrayList&lt;Character&gt;</code> que puede estar vacío o no.
     */
    private ArrayList<Character> getIndexList() {
        ArrayList<Character> indexList = new ArrayList<Character>();
        char index;

        for(int i = 0; i < options.size(); i++) {
            index = options.get(i).getIndex();
            indexList.add(index);
        }

        return indexList;
    }

    /**
     * Solicita el ingreso de una opción por teclado y guarda la selección.
     * <p>
     * Lee un único carácter de la entrada estándar, lo convierte a minúscula
     * y lo almacena en el atributo privado {@code selectedOption}.
     * </p>
     *
     * @return el carácter correspondiente a la opción seleccionada por el usuario.
     */
    private Character chooseOption() {
        Scanner scanner = new Scanner(System.in);
        selectedOption = scanner.next().toLowerCase().charAt(0);
        // scanner.close(); // No lo cierro para evitar cerrar System.in

        return selectedOption;
    }

    private void chooseValidOption() {
        Character option;

        do {
            option = chooseOption();

    /**
     * Imprime en la consola el contenido del menú: título, cuerpo, opciones y footer.
     */
    private void print() {
        System.out.println(title);
        System.out.println(body);
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getLabel());
        }
        System.out.println(footer);
    }
    //#endregion
}
