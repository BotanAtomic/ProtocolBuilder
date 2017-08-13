package com.ankamagames.dofus.network.messages.game.basic;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.social.AbstractSocialGroupInfos;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;

public class BasicWhoIsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 180;
    private boolean _isInitialized = false;
    private boolean self = false;
    private int position = -1;
    private String accountNickname = "";
    private int accountId = 0;
    private String playerName = "";
    private Number playerId = 0;
    private int areaId = 0;
    private int serverId = 0;
    private int originServerId = 0;
    private AbstractSocialGroupInfos[] socialGroups;
    private boolean verbose = false;
    private int playerState = 99;
    private FuncTree _socialGroupstree;


    public void serialize(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.self);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.verbose);
         param1.writeByte(_loc2_);
         param1.writeByte(this.position);
         param1.writeUTF(this.accountNickname);
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
         }
         param1.writeInt(this.accountId);
         param1.writeUTF(this.playerName);
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
         }
         param1.writeVarLong(this.playerId);
         param1.writeShort(this.areaId);
         param1.writeShort(this.serverId);
         param1.writeShort(this.originServerId);
         param1.writeShort(this.socialGroups.length);
         int _loc3_ = 0;
         while(_loc3_ < this.socialGroups.length)
         {
            param1.writeShort((this.socialGroups[_loc3_] as AbstractSocialGroupInfos).getTypeId());
            (this.socialGroups[_loc3_] as AbstractSocialGroupInfos).serialize(param1);
            _loc3_++;
         }
         param1.writeByte(this.playerState);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc4_ = 0;
         AbstractSocialGroupInfos _loc5_ = null;
         int _loc2_ = param1.readByte();
         this.self = BooleanByteWrapper.getFlag(_loc2_,0);
         this.verbose = BooleanByteWrapper.getFlag(_loc2_,1);
         this.position = param1.readByte();
         this.accountNickname = param1.readUTF();
         this.accountId = param1.readInt();
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element of BasicWhoIsMessage.accountId.");
         }
         this.playerName = param1.readUTF();
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element of BasicWhoIsMessage.playerId.");
         }
         this.areaId = param1.readShort();
         this.serverId = param1.readShort();
         this.originServerId = param1.readShort();
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(AbstractSocialGroupInfos,_loc4_);
            _loc5_.deserialize(param1);
            this.socialGroups.push(_loc5_);
            _loc3_++;
         }
         this.playerState = param1.readByte();
         if(this.playerState < 0)
         {
            throw new Exception("Forbidden value (" + this.playerState + ") on element of BasicWhoIsMessage.playerState.");
         }
    }

}