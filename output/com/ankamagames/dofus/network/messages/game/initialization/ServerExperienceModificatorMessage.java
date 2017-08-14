package com.ankamagames.dofus.network.messages.game.initialization;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ServerExperienceModificatorMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int experiencePercent = 0;
  public static final int protocolId = 6237;

  public void serialize(ICustomDataOutput param1) {
    if (this.experiencePercent < 0) {
      throw new Exception(
          "Forbidden value (" + this.experiencePercent + ") on element experiencePercent.");
    }
    param1.writeVarShort(this.experiencePercent);
  }

  public void deserialize(ICustomDataInput param1) {
    this.experiencePercent = param1.readVarUhShort();
    if (this.experiencePercent < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.experiencePercent
              + ") on element of ServerExperienceModificatorMessage.experiencePercent.");
    }
  }
}
