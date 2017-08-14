package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag.meeting;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.CharacterMinimalInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InviteInHavenBagClosedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public CharacterMinimalInformations hostInformations;
  private FuncTree _hostInformationstree;
  public static final int protocolId = 6645;

  public void serialize(ICustomDataOutput param1) {
    this.hostInformations.serializeAs_CharacterMinimalInformations(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.hostInformations = new CharacterMinimalInformations();
    this.hostInformations.deserialize(param1);
  }
}
