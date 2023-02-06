/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author darkn
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        String title = br.readLine();
        StringBuilder contentsBuilder = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            contentsBuilder.append(line).append("\n");
        }
        br.close();
        String content = contentsBuilder.toString();
        
        Note note = new Note(title, content);   
        request.setAttribute("note", note);
        
        String jspPath;
        String page = request.getParameter("page");
        if (page == null) {
            jspPath = "/WEB-INF/viewnote.jsp";
        } else {
            jspPath = "/WEB-INF/editnote.jsp";
        }
        
        getServletContext().getRequestDispatcher(jspPath)
            .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)));
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        bw.write(title + "\n" + contents);
        bw.close();
        response.sendRedirect("note");
    }

}
