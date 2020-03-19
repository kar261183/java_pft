package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Names extends ForwardingSet<NameData> {

  private Set<NameData> delegate;

  public Names(Names names) {
    this.delegate = new HashSet<NameData>(names.delegate);
  }

  public Names() {
    this.delegate = new HashSet<NameData>();
  }

  @Override
  protected Set<NameData> delegate() {
    return delegate;
  }
  public Names withAdded(NameData name){
    Names names = new Names(this);
    names.add(name);
    return names;
  }
  public Names without(NameData name){
    Names names = new Names(this);
    names.remove(name);
    return names;
  }
}
