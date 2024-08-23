public abstract class OfficeFactory {
    // Método creator 
    public abstract Office criarArquivoOffice();
    public void criarArquivo() {
        Office office = criarArquivoOffice();
        office.criar();
    }
}
