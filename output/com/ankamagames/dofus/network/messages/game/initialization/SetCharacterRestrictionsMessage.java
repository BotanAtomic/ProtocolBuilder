package com.ankamagames.dofus.network.messages.game.initialization;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.restriction.ActorRestrictionsInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SetCharacterRestrictionsMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number actorId = 0;
  public ActorRestrictionsInformations restrictions;
  private FuncTree _restrictionstree;
  public static final int protocolId = 170;

  public void serialize(ICustomDataOutput param1) {
    if (this.actorId < -9.007199254740992E15 || this.actorId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.actorId + ") on element actorId.");
    }
    param1.writeDouble(this.actorId);
    this.restrictions.serializeAs_ActorRestrictionsInformations(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.actorId = param1.readDouble();
    if (this.actorId < -9.007199254740992E15 || this.actorId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.actorId
              + ") on element of SetCharacterRestrictionsMessage.actorId.");
    }

    this.restrictions = new ActorRestrictionsInformations();
    this.restrictions.deserialize(param1);
  }
}
