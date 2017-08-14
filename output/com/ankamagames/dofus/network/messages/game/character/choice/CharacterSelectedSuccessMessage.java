package com.ankamagames.dofus.network.messages.game.character.choice;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.choice.CharacterBaseInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterSelectedSuccessMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public CharacterBaseInformations infos;
  public boolean isCollectingStats = false;
  private FuncTree _infostree;
  public static final int protocolId = 153;

  public void serialize(ICustomDataOutput param1) {
    this.infos.serializeAs_CharacterBaseInformations(param1);
    param1.writeBoolean(this.isCollectingStats);
  }

  public void deserialize(ICustomDataInput param1) {
    this.infos = new CharacterBaseInformations();
    this.infos.deserialize(param1);
    this.isCollectingStats = param1.readBoolean();
  }
}
