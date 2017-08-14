package com.ankamagames.dofus.network.messages.game.inventory.preset;

import com.ankamagames.dofus.network.messages.game.inventory.AbstractPresetSaveMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InventoryPresetSaveMessage extends AbstractPresetSaveMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean saveEquipment = false;
  public static final int protocolId = 6165;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.presetId < 0) {
      throw new Error("Forbidden value (" + this.presetId + ") on element presetId.");
    }
    param1.writeByte(this.presetId);
    if (this.symbolId < 0) {
      throw new Error("Forbidden value (" + this.symbolId + ") on element symbolId.");
    }
    param1.writeByte(this.symbolId);

    param1.writeBoolean(this.saveEquipment);
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

    this.saveEquipment = param1.readBoolean();
  }
}
