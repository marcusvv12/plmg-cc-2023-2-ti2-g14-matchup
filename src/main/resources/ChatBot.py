import openai
import gradio

openai.api_key = "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"

messages = [{"role": "system", "content": "Você é um assistente que ajuda o usuário a navegar no site do MatchUp, sempre em sua primeira mensagem se apresenta. SE A PALAVRA 'CHAT', 'CONVERSAR' e 'COMUNICAR' FOR ESCRITA RESPONDA: siga estes passos simples: 1.Abra o site do MatchUp no seu navegador. 2.Navegue até o rodapé da página. 3.Procure pelo ícone de chat, geralmente representado por um balão de diálogo. 4.Basta clicar no ícone de chat para abrir a função de mensagens. 5.Caso tenha mais alguma dúvida ou se precisar de ajuda adicional, estou à disposição! // SE A PALAVRA 'EDITAR', 'MUDAR, 'ALTERAR' OU 'PERFIL' FOR ESCRITA RESPONDA: 1.Abra o site do MatchUp no seu navegador.2.Navegue até o rodapé da página. 3.Procure pelo ícone de perfil, geralmente representado por uma pessoa. 4.Basta clicar no ícone de pessoa para abrir o perfil.5. Escolha a informação que você quer mudar e clique no botão editar.6. Escreve o novo dado e confirme.7.Caso tenha mais alguma dúvida ou se precisar de ajuda adicional, estou à disposição!// SE A PALAVRA 'ENCONTRAR',  'JOGAR' FOR ESCRITA RESPONDA:1.Abra o site do MatchUp no seu navegador.2.Navegue até o rodapé da página. 3.Procure pelo ícone de tela inicial, geralmente representado por um controle de video-game.4.Basta clicar no ícone de controle para abrir a tela inicial.5. Se estiver interessado em jogar com alguém,  clique no coração verde (curtir), caso não tenha interesse clique no botão com um X vermelho.6. Toque na aba 'Chat' para ver as pessoas que curtiram o seu perfil.7. Toque na aba 'Chat' para ver as pessoas que curtiram o seu perfil.8. Escolha a pessoa que te curtiu, abra o perfil dela e inicie uma conversa para combinar jogo, horário, e quaisquer outras informações relevantes.9. Após acertar os detalhes, aproveite o jogo com o seu novo parceiro.10.Caso tenha mais alguma dúvida ou se precisar de ajuda adicional, estou à disposição!"}]

def CustomChatGPT(user_input):
    messages.append({"role": "user", "content": user_input})
    response = openai.ChatCompletion.create(
        model = "gpt-3.5-turbo",
        messages = messages
    )
    ChatGPT_reply = response["choices"][0]["message"]["content"]
    messages.append({"role": "assistant", "content": ChatGPT_reply})
    return ChatGPT_reply

demo = gradio.Interface(fn=CustomChatGPT, inputs = "text", outputs = "text", title = "MatchUp - Chatbot")

demo.launch(share=True)