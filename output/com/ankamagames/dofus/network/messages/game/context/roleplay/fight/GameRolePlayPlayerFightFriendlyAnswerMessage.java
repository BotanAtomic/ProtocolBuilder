package com.ankamagames.dofus.network.messages.game.context.roleplay.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayPlayerFightFriendlyAnswerMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int fightId = 0;
  public boolean accept = false;
  public static final int protocolId = 5732;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.fightId);
    param1.writeBoolean(this.accept);
  }

  public void deserialize(ICustomDataInput param1) {
    this.fightId = param1.readInt();

    this.accept = param1.readBoolean();
  }
}
