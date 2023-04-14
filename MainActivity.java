package com.example.comanda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText valorTotal;
    private EditText taxaServico;
    private EditText numPessoas;
    private EditText numCasais;
    private EditText resultadoPessoaServico;
    private EditText resultadoCasalServico;
    private TextView resultadoPessoaComServico;
    private TextView resultadoPessoaSemServico;
    private TextView resultadoCasalComServico;
    private TextView resultadoCasalSemServico;
    private TextView resultadoPessoaCasalComServico;
    private TextView resultadoPessoaCasalSemServico;
    private TextView resultadoPessoaCasalServico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorTotal = findViewById(R.id.valor_total);
        taxaServico = findViewById(R.id.taxa_servico);
        numPessoas = findViewById(R.id.quantidade_pessoas);
        numCasais = findViewById(R.id.quantidade_casais);
        resultadoPessoaServico = findViewById(R.id.resultadoPessoaServico);
        resultadoCasalServico = findViewById(R.id.resultado_casal_servico);
        resultadoPessoaComServico = findViewById(R.id.resultado_pessoa_com_servico);
        resultadoPessoaSemServico = findViewById(R.id.resultado_pessoa_sem_servico);
        resultadoCasalComServico = findViewById(R.id.resultado_casal_com_servico);
        resultadoCasalSemServico = findViewById(R.id.resultado_casal_sem_servico);
        resultadoPessoaCasalComServico = findViewById(R.id.resultado_pessoa_casal_com_servico);
        resultadoPessoaCasalSemServico = findViewById(R.id.resultado_pessoa_casal_sem_servico);
        resultadoPessoaCasalServico = findViewById(R.id.resultado_pessoa_casal_servico);

        Button calcularButton = findViewById(R.id.calcular_pessoa);
        calcularButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                double total = Double.parseDouble(valorTotal.getText().toString());
                double taxa = Double.parseDouble(taxaServico.getText().toString()) / 100.0;
                int pessoas = Integer.parseInt(numPessoas.getText().toString());
                int casais = Integer.parseInt(numCasais.getText().toString());

                double valorComTaxa = total * (1 + taxa);
                double valorPessoaServico = total * taxa;
                double valorPessoaComServico = valorComTaxa / pessoas;
                double valorPessoaSemServico = total / pessoas;


                resultadoPessoaServico.setText(String.format("R$ %.2f", valorPessoaServico));
                resultadoPessoaComServico.setText(String.format("R$ %.2f", valorPessoaComServico));
                resultadoPessoaSemServico.setText(String.format("R$ %.2f", valorPessoaSemServico));

            }

        });
        Button calcularButton2 = findViewById(R.id.calcular_casal);
        calcularButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                double total = Double.parseDouble(valorTotal.getText().toString());
                double taxa = Double.parseDouble(taxaServico.getText().toString()) / 100.0;
                int pessoas = Integer.parseInt(numPessoas.getText().toString());
                int casais = Integer.parseInt(numCasais.getText().toString());

                double valorComTaxa = total * (1 + taxa);
                double valorCasalServico = (total * taxa)*2;
                double valorCasalComServico = valorComTaxa / (casais * 2);
                double valorCasalSemServico = total / (casais * 2);


                resultadoCasalServico.setText(String.format("R$ %.2f", valorCasalServico));
                resultadoCasalComServico.setText(String.format("R$ %.2f", valorCasalComServico));
                resultadoCasalSemServico.setText(String.format("R$ %.2f", valorCasalSemServico));

            }

        });
        Button calcularButton3 = findViewById(R.id.calcular_ambos);
        calcularButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                double total = Double.parseDouble(valorTotal.getText().toString());
                double taxa = Double.parseDouble(taxaServico.getText().toString()) / 100.0;
                int pessoas = Integer.parseInt(numPessoas.getText().toString());
                int casais = Integer.parseInt(numCasais.getText().toString());

                double valorComTaxa = total * (1 + taxa);
                double valorPessoaServico = total * taxa;
                double valorCasalServico = (total * taxa)*2;
                double valorPessoaComServico = valorComTaxa / pessoas;
                double valorPessoaSemServico = total / pessoas;
                double valorCasalComServico = valorComTaxa / (casais * 2);
                double valorCasalSemServico = total / (casais * 2);
                double valorPessoaECasalComServico = valorPessoaComServico + valorCasalComServico;
                double valorPessoaECasalSemServico = valorPessoaSemServico + valorCasalSemServico;
                double valorPessoaECasalServico = valorPessoaServico + valorCasalServico;


                resultadoPessoaCasalComServico.setText(String.format("R$ %.2f", valorPessoaECasalComServico));
                resultadoPessoaCasalSemServico.setText(String.format("R$ %.2f", valorPessoaECasalSemServico));
                resultadoPessoaCasalServico.setText(String.format("R$ %.2f", valorPessoaECasalServico));
            }

        });
    }

}