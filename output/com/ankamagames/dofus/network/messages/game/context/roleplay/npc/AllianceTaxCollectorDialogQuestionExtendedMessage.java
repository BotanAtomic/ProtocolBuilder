package com.ankamagames.dofus.network.messages.game.context.roleplay.npc;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicNamedAllianceInformations;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicGuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceTaxCollectorDialogQuestionExtendedMessage extends TaxCollectorDialogQuestionExtendedMessage implements INetworkMessage {

    private int protocolId = 6445;
    private boolean _isInitialized = false;
    private BasicNamedAllianceInformations alliance;
    private FuncTree _alliancetree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_TaxCollectorDialogQuestionExtendedMessage(param1);
         this.alliance.serializeAs_BasicNamedAllianceInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.alliance = new BasicNamedAllianceInformations();
         this.alliance.deserialize(param1);
         this.alliance = new BasicNamedAllianceInformations();
         this.alliance.deserialize(param1);
         this.alliance = new BasicNamedAllianceInformations();
         this.alliance.deserialize(param1);
         super.deserialize(param1);
         this.alliance = new BasicNamedAllianceInformations();
         this.alliance.deserialize(param1);
    }

}