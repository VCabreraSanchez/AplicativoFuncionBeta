package Clases;
import java.util.ArrayList;
import java.util.List;

public class Recursos {
    public class Recurso {
        private String titulo;
        private String enlace;

        public Recurso(String titulo, String enlace) {
            this.titulo = titulo;
            this.enlace = enlace;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getEnlace() {
            return enlace;
        }
    }

    private List<Recurso> recursos;

    public Recursos() {
        recursos = new ArrayList<>();
        recursos.add(new Recurso("Libro de Ingeniería", "https://www.ingebook.com/ib/NPcd/IB_BooksVis?cod_primaria=1000187&codigo_libro=94"));
        recursos.add(new Recurso("Funciones Eulerianas", "https://riull.ull.es/xmlui/bitstream/handle/915/2535/Las+funciones+eulerianas+Gamma+y+Beta+complejas.pdf?sequence=1"));
        recursos.add(new Recurso("Métodos Matemáticos", "https://metodos.fam.cie.uva.es/~latex/caplibro.pdf"));
        recursos.add(new Recurso("Curso de Matemáticas", "https://impa.br/wp-content/uploads/2022/03/32CBM08_eBook.pdf"));
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }
}
