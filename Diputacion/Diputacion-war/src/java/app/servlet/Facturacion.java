///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package app.servlet;
//
//import app.entity.AsignacionFijo;
//import app.entity.AsignacionMovil;
//import app.entity.Linea;
//import app.entity.Usuario;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author Francisco Manuel Fernández Lozano
// */
//@WebServlet(name = "Facturacion", urlPatterns = {"/facturacion"})
//public class Facturacion extends HttpServlet {
//
//	/**
//	 * Processes requests for both HTTP
//	 * <code>GET</code> and
//	 * <code>POST</code> methods.
//	 *
//	 * @param request servlet request
//	 * @param response servlet response
//	 * @throws ServletException if a servlet-specific error occurs
//	 * @throws IOException if an I/O error occurs
//	 */
//	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		if (request.getSession().getAttribute("usuario") == null) {
//			// No hay usuario logeado
//			response.sendRedirect("login.jsp");
//			return;
//		}
//
////		String action = request.getParameter("action");
////		action = action == null ? "list" : action.toLowerCase();
//
//		listarLlamadas(request, response);
//	}
//
//	private void listarLlamadas(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
//		
//		int indexLineaMostrar = -1;
//		Object asignacionMostrar = null;
//		List<Linea> lineas = new ArrayList<Linea>();
//
//		Collection<AsignacionFijo> asigFijos = usuario.getAsignacionFijoCollection();
//		for (AsignacionFijo asig : asigFijos) {
//			if (asig.getAsignado() == 'S') {
//				if (asignacionMostrar == null) {
//					asignacionMostrar = asig;
//					indexLineaMostrar = lineas.size();
//				}
//				//Linea linea = asig.getLinea();
//				lineas.add(linea);
//			}
//		}
//		
//		Collection<AsignacionMovil> asigMoviles = usuario.getAsignacionMovilCollection();
//		for (AsignacionMovil asig : asigMoviles) {
//			if (asig.getAsignado() == 'S') {
//				if (asignacionMostrar == null) {
//					asignacionMostrar = asig;
//					indexLineaMostrar = lineas.size();
//				}
//				Linea linea = asig.getLinea();
//				lineas.add(linea);
//			}
//		}
//		
//		request.setAttribute("lineas", lineas);
//		request.setAttribute("asignacion", asignacionMostrar);
//		request.setAttribute("indexLinea", indexLineaMostrar);
//
//		RequestDispatcher rd = getServletContext().getRequestDispatcher("/facturacion.jsp");
//		rd.forward(request, response);
//	}
//
////    private void listarLlamadas(HttpServletRequest request, HttpServletResponse response, Linea linea)
////            throws ServletException, IOException {
////        
////    }
//	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//	/**
//	 * Handles the HTTP
//	 * <code>GET</code> method.
//	 *
//	 * @param request servlet request
//	 * @param response servlet response
//	 * @throws ServletException if a servlet-specific error occurs
//	 * @throws IOException if an I/O error occurs
//	 */
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		processRequest(request, response);
//	}
//
//	/**
//	 * Handles the HTTP
//	 * <code>POST</code> method.
//	 *
//	 * @param request servlet request
//	 * @param response servlet response
//	 * @throws ServletException if a servlet-specific error occurs
//	 * @throws IOException if an I/O error occurs
//	 */
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		processRequest(request, response);
//	}
//
//	/**
//	 * Returns a short description of the servlet.
//	 *
//	 * @return a String containing servlet description
//	 */
//	@Override
//	public String getServletInfo() {
//		return "Short description";
//	}// </editor-fold>
//}
