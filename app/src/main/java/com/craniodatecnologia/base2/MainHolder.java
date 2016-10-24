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
 
}
