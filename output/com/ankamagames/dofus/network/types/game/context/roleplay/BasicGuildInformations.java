package package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.dofus.network.types.game.social.AbstractSocialGroupInfos;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class BasicGuildInformations extends AbstractSocialGroupInfos implements INetworkType {

    private int protocolId = 365;
    private int guildId = 0;
    private String guildName = "";
    private int guildLevel = 0;


    public int getTypeId() {
         return 365;
    }

    public BasicGuildInformations initBasicGuildInformations(int param1,String  param2,int  param3) {
         this.guildId = param1;
         this.guildName = param2;
         this.guildLevel = param3;
         return this;
    }

    public void reset() {
         this.guildId = 0;
         this.guildName = "";
         this.guildLevel = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_BasicGuildInformations(param1);
    }

    public void serializeAs_BasicGuildInformations(ICustomDataOutput param1) {
         super.serializeAs_AbstractSocialGroupInfos(param1);
         if(this.guildId < 0)
            throw new Exception("Forbidden value (" + this.guildId + ") on element guildId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_BasicGuildInformations(param1);
    }

    public void deserializeAs_BasicGuildInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._guildIdFunc(param1);
         this._guildNameFunc(param1);
         this._guildLevelFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_BasicGuildInformations(param1);
    }

    public void deserializeAsyncAs_BasicGuildInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._guildIdFunc);
         param1.addChild(this._guildNameFunc);
         param1.addChild(this._guildLevelFunc);
    }

    private void _guildIdFunc(ICustomDataInput param1) {
         this.guildId = param1.readVarUhInt();
         if(this.guildId < 0)
            throw new Exception("Forbidden value (" + this.guildId + ") on element of BasicGuildInformations.guildId.");
    }

    private void _guildNameFunc(ICustomDataInput param1) {
         this.guildName = param1.readUTF();
    }

    private void _guildLevelFunc(ICustomDataInput param1) {
         this.guildLevel = param1.readUnsignedByte();
         if(this.guildLevel < 0 || this.guildLevel > 200)
            throw new Exception("Forbidden value (" + this.guildLevel + ") on element of BasicGuildInformations.guildLevel.");
    }

}