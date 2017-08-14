package com.ankamagames.dofus.network.messages.game.context.mount;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MountInformationRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number id = 0;
  public Number time = 0;
  public static final int protocolId = 5972;

  public void serialize(ICustomDataOutput param1) {
    if (this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeDouble(this.id);
    if (this.time < -9.007199254740992E15 || this.time > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.time + ") on element time.");
    }
    param1.writeDouble(this.time);
  }

  public void deserialize(ICustomDataInput param1) {
    this.id = param1.readUTF();

    this.time = param1.readUnsignedByte();
    if (this.time < 0 || this.time > 255) {
      throw new Exception(
          "Forbidden value (" + this.time + ") on element of SkillActionDescriptionTimed.time.");
    }
  }
}
