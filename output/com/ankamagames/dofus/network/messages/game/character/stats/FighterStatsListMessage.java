package com.ankamagames.dofus.network.messages.game.character.stats;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.characteristic.CharacterCharacteristicsInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FighterStatsListMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public CharacterCharacteristicsInformations stats;
  private FuncTree _statstree;
  public static final int protocolId = 6322;

  public void serialize(ICustomDataOutput param1) {
    this.stats.serializeAs_CharacterCharacteristicsInformations(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.stats = new CharacterCharacteristicsInformations();
    this.stats.deserialize(param1);
  }
}
