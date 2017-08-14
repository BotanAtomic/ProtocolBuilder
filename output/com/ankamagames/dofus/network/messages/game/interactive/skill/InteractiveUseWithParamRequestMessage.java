package com.ankamagames.dofus.network.messages.game.interactive.skill;

import com.ankamagames.dofus.network.messages.game.interactive.InteractiveUseRequestMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InteractiveUseWithParamRequestMessage extends InteractiveUseRequestMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int id = 0;
  public static final int protocolId = 6715;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.elemId < 0) {
      throw new Error("Forbidden value (" + this.elemId + ") on element elemId.");
    }
    param1.writeVarInt(this.elemId);
    if (this.skillInstanceUid < 0) {
      throw new Error(
          "Forbidden value (" + this.skillInstanceUid + ") on element skillInstanceUid.");
    }
    param1.writeVarInt(this.skillInstanceUid);

    param1.writeInt(this.id);
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

    this.id = param1.readUTF();
  }
}
