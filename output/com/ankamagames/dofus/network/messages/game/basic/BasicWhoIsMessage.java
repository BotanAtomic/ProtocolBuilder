package com.ankamagames.dofus.network.messages.game.basic;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.social.AbstractSocialGroupInfos;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class BasicWhoIsMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean self = false;
  public int position = -1;
  public String accountNickname = "";
  public int accountId = 0;
  public String playerName = "";
  public Number playerId = 0;
  public int areaId = 0;
  public int serverId = 0;
  public int originServerId = 0;
  public Vector<AbstractSocialGroupInfos> socialGroups;
  public boolean verbose = false;
  public int playerState = 99;
  private FuncTree _socialGroupstree;
  public static final int protocolId = 180;

  public void serialize(ICustomDataOutput param1) {
    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.self);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.verbose);
    param1.writeByte(_loc2_);
    param1.writeByte(this.position);
    param1.writeUTF(this.accountNickname);
    if (this.accountId < 0) {
      throw new Error("Forbidden value (" + this.accountId + ") on element accountId.");
    }
    param1.writeInt(this.accountId);
    param1.writeUTF(this.playerName);
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.playerId + ") on element playerId.");
    }
    param1.writeVarLong(this.playerId);
    param1.writeShort(this.areaId);
    param1.writeShort(this.serverId);
    param1.writeShort(this.originServerId);
    param1.writeShort(this.socialGroups.length);
    int _loc3_ = 0;
    while (_loc3_ < this.socialGroups.length) {
      param1.writeShort(((AbstractSocialGroupInfos) (this.socialGroups[_loc3_])).getTypeId());
      ((AbstractSocialGroupInfos) this.socialGroups[_loc3_]).serialize(param1);
      _loc3_++;
    }
    param1.writeByte(this.playerState);
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    AbstractSocialGroupInfos _loc5_ = null;
    int _loc2_ = param1.readByte();
    this.sex = BooleanByteWrapper.getFlag(_loc2_, 0);
    this.isRideable = BooleanByteWrapper.getFlag(_loc2_, 1);
    this.isWild = BooleanByteWrapper.getFlag(_loc2_, 2);
    this.isFecondationReady = BooleanByteWrapper.getFlag(_loc2_, 3);
    this.useHarnessColors = BooleanByteWrapper.getFlag(_loc2_, 4);

    this.position = param1.readUnsignedByte();
    if (this.position < 0 || this.position > 255) {
      throw new Error("Forbidden value (" + this.position + ") on element of PresetItem.position.");
    }

    this.accountNickname = param1.readUTF();

    this.accountId = param1.readInt();
    if (this.accountId < 0) {
      throw new Error(
          "Forbidden value (" + this.accountId + ") on element of GuildMember.accountId.");
    }

    this.playerName = param1.readUTF();

    this.playerId = param1.readVarUhLong();
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.playerId + ") on element of TaxCollectorMovement.playerId.");
    }

    this.areaId = param1.readShort();

    this.serverId = param1.readShort();

    this.originServerId = param1.readShort();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readUnsignedShort();
      _loc5_ = ProtocolTypeManager.getInstance(AbstractSocialGroupInfos, _loc4_);
      _loc5_.deserialize(param1);
      this.socialGroups.push(_loc5_);
      _loc3_++;
    }
    this.playerState = param1.readByte();
    if (this.playerState < 0) {
      throw new Error(
          "Forbidden value ("
              + this.playerState
              + ") on element of FriendInformations.playerState.");
    }
  }
}
