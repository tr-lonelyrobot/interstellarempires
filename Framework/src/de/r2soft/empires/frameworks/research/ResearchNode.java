package de.r2soft.empires.frameworks.research;

import java.util.Set;

/**
 * A research node that can be extended to populate a @ResearchNodeTree
 * 
 * @author Katharina <kookie@spacekookie.de>
 * 
 */
public abstract class ResearchNode {

  private Long id;
  private String name;
  private ResearchNode parent;
  private Set<ResearchNode> children;

}
