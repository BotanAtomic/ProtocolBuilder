package com.ankamagames.dofus.network.types.game.paddock;

import com.ankamagames.dofus.network.types.game.context.roleplay.ObjectItemInRolePlay;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.mount.ItemDurability;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PaddockItem extends ObjectItemInRolePlay implements INetworkType {

  public ItemDurability durability;
  private FuncTree _durabilitytree;
  public static final int protocolId = 185;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.cellId < 0 || this.cellId > 559) {
      throw new Error("Forbidden value (" + this.cellId + ") on element cellId.");
    }
    param1.writeVarShort(this.cellId);
    if (this.objectGID < 0) {
      throw new Error("Forbidden value (" + this.objectGID + ") on element objectGID.");
    }
    param1.writeVarShort(this.objectGID);

    this.durability.serializeAs_ItemDurability(param1);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.durability = new ItemDurability();
    this.durability.deserialize(param1);
  }
}
