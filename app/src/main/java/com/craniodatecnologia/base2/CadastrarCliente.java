package com.craniodatecnologia.base2;
import android.app.*;
import android.os.*;
import android.view.*;
import android.content.*;
import android.widget.*;
import com.craniodatecnologia.base2.repositorio.*;
import com.craniodatecnologia.base2.models.*;
import com.craniodatecnologia.base2.util.*;

public class CadastrarCliente extends Activity
{

	EditText razaoSocial, nomeFantasia, telefone, telefoneComercial,
	celular, contato, email, cpf, rg, endereco, bairro, cep,
	cidade, uf, observacoes;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastrar_pessoa);

		razaoSocial = (EditText) findViewById(R.id.nomeCliente);
		
		nomeFantasia = (EditText) findViewById(R.id.nomeFantasiaCliente);
		
		telefone = (EditText) findViewById(R.id.telefoneCliente);
		telefone.addTextChangedListener(Mask.insert("(##)####-####", telefone));
		
		telefoneComercial = (EditText) findViewById(R.id.telefoneComercialCliente);
		telefoneComercial.addTextChangedListener(Mask.insert("(##)####-####", telefoneComercial));
		
		celular = (EditText) findViewById(R.id.celularCliente);
		celular.addTextChangedListener(Mask.insert("(##)####-####", celular));
		
		contato = (EditText) findViewById(R.id.contatoCliente);
		
		email = (EditText) findViewById(R.id.emailCliente);
		
		cpf = (EditText) findViewById(R.id.cpfCliente);
		
		rg = (EditText) findViewById(R.id.rgCliente);
		
		endereco = (EditText) findViewById(R.id.enderecoCliente);
		
		bairro = (EditText) findViewById(R.id.bairroCliente);
		
		cep = (EditText) findViewById(R.id.cepCliente);
		cep.addTextChangedListener(Mask.insert("##.###-###", cep));
		
		cidade = (EditText) findViewById(R.id.cidadeCliente);
		
		uf = (EditText) findViewById(R.id.ufCliente);
		
		observacoes = (EditText) findViewById(R.id.observacoesCliente);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_cadastro, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{

			case R.id.salvarCliente:
				menuSalvar();
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
}
