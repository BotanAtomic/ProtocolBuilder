package com.ankamagames.dofus.network.messages.game.guild.tax;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.CharacterMinimalPlusLookInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildFightPlayersHelpersJoinMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int fightId = 0;
  public CharacterMinimalPlusLookInformations playerInfo;
  private FuncTree _playerInfotree;
  public static final int protocolId = 5720;

  public void serialize(ICustomDataOutput param1) {
    if (this.fightId < 0) {
      throw new Exception("Forbidden value (" + this.fightId + ") on element fightId.");
    }
    param1.writeInt(this.fightId);
    this.playerInfo.serializeAs_CharacterMinimalPlusLookInformations(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.fightId = param1.readInt();

    this.playerInfo = new CharacterMinimalPlusLookInformations();
    this.playerInfo.deserialize(param1);
  }
}
