

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class connexionControleur
 */
///baptiste

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/connexionControleur")
public class connexionControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public connexionControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/connexionVue.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  seConnecter(request, response);
		//  request.getRequestDispatcher("/clientVue.jsp").forward(request, response);
		}



  public void seConnecter(HttpServletRequest request, HttpServletResponse response) {
    // Récupérer les données du formulaire de connexion
    String identifiantConnexion = request.getParameter("identifiantConnexion");
    String mdp = request.getParameter("mdp");

    // Valider les données de connexion
    if (identifiantConnexion != null && !identifiantConnexion.isEmpty() && mdp != null && !mdp.isEmpty()) {
      EmployeDAOModele dao = new EmployeDAOModele();
      EmployeBeanModele employe = null;
	try {
		employe = dao.seConnecter(identifiantConnexion, mdp);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

      if (employe != null) {
        // Démarrer une session pour l'utilisateur
        HttpSession session = request.getSession();
        session.setAttribute("employe", employe);

        // Rediriger l'utilisateur vers la page appropriée
       /* try {
			response.sendRedirect("clientVue.jsp");// ici on met la page vers laquelle on redirige
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        String role = employe.getRole();
        if (role.equals("Préparateur de commandes")) {
            try {
				response.sendRedirect("expeditionVue.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else if (role.equals("Gestionnaire des ventes")) {
            try {
				response.sendRedirect("financeVue.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else if (role.equals("Commercial des ventes")) {
            try {
				response.sendRedirect("commandeVue.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else {
            try {
				response.sendRedirect("clientVue.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
      } else {
        // Afficher un message d'erreur si les données de connexion sont invalides
        request.setAttribute("messageErreur", "Nom d'utilisateur ou mot de passe incorrect.");
        try {
			request.getRequestDispatcher("connexionVue.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
    } else {
      // Afficher un message d'erreur si les données de connexion sont manquantes
      request.setAttribute("messageErreur", "Veuillez saisir un nom d'utilisateur et un mot de passe.");
      try {
		request.getRequestDispatcher("connexionVue.jsp").forward(request, response);
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
  }
}






/*@WebServlet("/connexionControleur")
public class connexionControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  /*  public connexionControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	request.getRequestDispatcher("/connexionVue.jsp").forward(request, response);
/*	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
///*	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	// TODO Auto-generated method stub
//		doGet(request, response);
//	}

//}

