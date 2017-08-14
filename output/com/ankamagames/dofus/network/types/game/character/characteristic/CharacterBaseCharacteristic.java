package com.ankamagames.dofus.network.types.game.character.characteristic;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterBaseCharacteristic extends Object implements INetworkType {

  public int base = 0;
  public int additionnal = 0;
  public int objectsAndMountBonus = 0;
  public int alignGiftBonus = 0;
  public int contextModif = 0;
  public static final int protocolId = 4;

  public void serialize(ICustomDataOutput param1) {
    param1.writeVarShort(this.base);
    param1.writeVarShort(this.additionnal);
    param1.writeVarShort(this.objectsAndMountBonus);
    param1.writeVarShort(this.alignGiftBonus);
    param1.writeVarShort(this.contextModif);
  }

  public void deserialize(ICustomDataInput param1) {
    this.base = param1.readVarShort();

    this.additionnal = param1.readVarShort();

    this.objectsAndMountBonus = param1.readVarShort();

    this.alignGiftBonus = param1.readVarShort();

    this.contextModif = param1.readVarShort();
  }
}
