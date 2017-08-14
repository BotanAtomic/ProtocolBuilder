package com.ankamagames.dofus.network.messages.game.character.creation;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterCanBeCreatedRequestMessage extends NetworkMessage implements INetworkMessage {

  public static final int protocolId = 6732;

  public void serialize(ICustomDataOutput param1) {}

  public void deserialize(ICustomDataInput param1) {}
}
