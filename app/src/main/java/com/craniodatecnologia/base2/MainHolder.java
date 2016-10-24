public class NossoViewHolder extends RecyclerView.ViewHolder {
   
    final TextView nome;
    final TextView descricao;
    final TextView preco;
    final TextView autor;
 
    public NossoViewHolder(View view) {
        super(view);
        nome = (TextView) view.findViewById(R.id.item_livro_nome);
        // restante das buscas
    }
   
   @Override
public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
 
    NossoViewHolder holder = new NossoViewHolder();
 
    return holder;
}
   
   @Override
public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
 
    View view = LayoutInflater.from(context).inflate(R.layout.item_livro, parent, false);
    
    NossoViewHolder holder = new NossoViewHolder(view);
 
    return holder;
}
 
}
