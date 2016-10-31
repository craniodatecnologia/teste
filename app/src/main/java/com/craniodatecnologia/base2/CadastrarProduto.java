package com.craniodatecnologia.base2;
import android.app.*;
import android.os.*;
import android.view.*;

public class CadastrarProduto extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastrar_produto);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_cadastro_produtos, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{

			case R.id.salvarProduto:
				//menuSalvar();
				return true;

				/*
				 case R.id.sair:
				 finish();
				 return true;
				 */

			default:
				return super.onOptionsItemSelected(item);
		}
	}
/*
	public void menuSalvar()
	{
		if (razaoSocial.getText().toString().isEmpty())
		{
			razaoSocial.setError("Campo obrigatório");
			razaoSocial.requestFocus();
		} 
		else if (cpf.getText().length() < 11) {
			cpf.setError("CPF/CNPJ inválido");
			cpf.requestFocus();
		}
		else
		{
			ListaClientes listaClientes = new ListaClientes();
			listaClientes.setRazaoSocial(razaoSocial.getText().toString());
			listaClientes.setNomeFantasia(nomeFantasia.getText().toString());
			listaClientes.setTelefone(telefone.getText().toString());
			listaClientes.setTelefoneComercial(telefoneComercial.getText().toString());
			listaClientes.setCelular(celular.getText().toString());
			listaClientes.setContato(contato.getText().toString());
			listaClientes.setEmail(email.getText().toString());
			listaClientes.setCpf(cpf.getText().toString());
			listaClientes.setRg(rg.getText().toString());
			listaClientes.setEndereco(endereco.getText().toString());
			listaClientes.setBairro(bairro.getText().toString());
			listaClientes.setCep(cep.getText().toString());
			listaClientes.setCidade(cidade.getText().toString());
			listaClientes.setUf(uf.getText().toString());
			listaClientes.setObservacoes(observacoes.getText().toString());

			new RepositorioClientes(CadastrarCliente.this).Salvar(listaClientes);

			Toast toast = Toast.makeText(getApplicationContext(), "Cliente cadastrado com sucesso", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();

			finishAndRemoveTask();
		}
	}
	*/
}
