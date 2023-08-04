package presenter;

import Creater.TreeService;
import Tree.SimpleTree;
import View.View;

import java.util.ArrayList;

public class Presenter {

    private View view;
    private TreeService treeService;

    public Presenter(View view){
        this.view = view;
        treeService = new TreeService();
    }

    public void showExistingTrees(){
        TreeService.showExistingTrees();
    }
    public void createNewTree(){
        TreeService.createNewTree();
    }
    public void exitProgram(){
        TreeService.exitProgram();
    }



}
